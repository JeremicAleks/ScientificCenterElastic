package com.elastic.scientificenterelastic.lucene.indexing;


import com.elastic.scientificenterelastic.lucene.indexing.handlers.*;
import com.elastic.scientificenterelastic.lucene.model.IndexUnit;
import com.elastic.scientificenterelastic.lucene.model.IndexUnitUser;
import com.elastic.scientificenterelastic.repository.elastic.ArticleElasticRepository;
import com.elastic.scientificenterelastic.repository.elastic.UserElasticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class Indexer {
	

	@Autowired
	private ArticleElasticRepository repository;
	@Autowired
	private UserElasticRepository userElasticRepository;
	
	public Indexer() {
	}
	
	
	public boolean delete(String filename){
		if(repository.equals(filename)){
			repository.delete(repository.findByFilename(filename));
			return true;
		} else
			return false;
		
	}
	
	public boolean update(IndexUnit unit){
		unit = repository.save(unit);
		if(unit!=null)
			return true;
		else
			return false;
	}
	
	public boolean add(IndexUnit unit){
		unit = repository.index(unit);
		if(unit!=null)
			return true;
		else
			return false;
	}
	public boolean addUser(IndexUnitUser unit){
		unit = userElasticRepository.index(unit);
		if(unit!=null)
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * @param file Direktorijum u kojem se nalaze dokumenti koje treba indeksirati
	 */
	public int index(File file){		
		DocumentHandler handler = null;
		String fileName = null;
		int retVal = 0;
		try {
			File[] files;
			if(file.isDirectory()){
				files = file.listFiles();
			}else{
				files = new File[1];
				files[0] = file;
			}
			for(File newFile : files){
				if(newFile.isFile()){
					fileName = newFile.getName();
					handler = getHandler(fileName);
					if(handler == null){
						System.out.println("Nije moguce indeksirati dokument sa nazivom: " + fileName);
						continue;
					}	
					if(add(handler.getIndexUnit(newFile)))
						retVal++;
				} else if (newFile.isDirectory()){
					retVal += index(newFile);
				}
			}
			System.out.println("indexing done");
		} catch (Exception e) {
			System.out.println("indexing NOT done");
		}
		return retVal;
	}
	

	public DocumentHandler getHandler(String fileName){
		if(fileName.endsWith(".txt")){
			return new TextDocHandler();
		}else if(fileName.endsWith(".pdf")){
			return new PDFHandler();
		}else if(fileName.endsWith(".doc")){
			return new WordHandler();
		}else if(fileName.endsWith(".docx")){
			return new Word2007Handler();
		}else{
			return null;
		}
	}

}
