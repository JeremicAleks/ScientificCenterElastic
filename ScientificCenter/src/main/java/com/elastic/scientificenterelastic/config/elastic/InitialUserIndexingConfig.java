package com.elastic.scientificenterelastic.config.elastic;


import com.elastic.scientificenterelastic.domain.Location;
import com.elastic.scientificenterelastic.domain.Role;
import com.elastic.scientificenterelastic.domain.User;
import com.elastic.scientificenterelastic.globals.RoleType;
import com.elastic.scientificenterelastic.helper.IndexerHelper;
import com.elastic.scientificenterelastic.lucene.indexing.Indexer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitialUserIndexingConfig {

    @Autowired
    private Indexer indexer;

    @PostConstruct
    public void initUser(){
//        AUTORI

        Set<Role> roles1 = new HashSet<>(Collections.singletonList(new Role(RoleType.AUTHOR)));
        User user1 = new User("Autor1","Autor1","autor1",roles1,new Location("Novi Beograd 2",44.82,20.41));
        user1.setUserId(9L);
         indexer.addUser(IndexerHelper.indexUserHelper(user1));

        Set<Role> roles2 = new HashSet<>(Collections.singletonList(new Role(RoleType.AUTHOR)));
        User user2 = new User("Autor2","Autor2","autor2",roles2,new Location("Novi Sad",45.25,19.83));
        user2.setUserId(10L);
        indexer.addUser(IndexerHelper.indexUserHelper(user2));

        Set<Role> roles21 = new HashSet<>(Collections.singletonList(new Role(RoleType.REVIEWER)));
        User user21 = new User("Recenzent1","Recenzent1","recenzent1",roles21,new Location("New York",40.73,-74.01));
        user21.setUserId(6L);
        indexer.addUser(IndexerHelper.indexUserHelper(user21));

        Set<Role> roles22 = new HashSet<>(Collections.singletonList(new Role(RoleType.REVIEWER)));
        User user22 = new User("Recenzent2","Recenzent2","recenzent2",roles22,new Location("Novi Beograd",44.80,20.43));
        user22.setUserId(7L);
        indexer.addUser(IndexerHelper.indexUserHelper(user22));

        Set<Role> roles23 = new HashSet<>(Collections.singletonList(new Role(RoleType.REVIEWER)));
        User user23 = new User("Recenzent3","Recenzent3","recenzent3",roles23,new Location("Zemun",44.85,20.38));
        user23.setUserId(8L);
        indexer.addUser(IndexerHelper.indexUserHelper(user23));


    }

}
