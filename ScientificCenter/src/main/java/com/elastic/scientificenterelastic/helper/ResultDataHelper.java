package com.elastic.scientificenterelastic.helper;

import com.elastic.scientificenterelastic.dto.GeoSearchResponseDTO;
import com.elastic.scientificenterelastic.dto.MoreLikeThisResponeDTO;
import com.elastic.scientificenterelastic.dto.UserDTO;
import com.elastic.scientificenterelastic.globals.RoleType;
import com.elastic.scientificenterelastic.lucene.model.ResultData;
import com.elastic.scientificenterelastic.lucene.model.ResultDataUser;
import com.elastic.scientificenterelastic.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class ResultDataHelper {
    private static UserService userService;

    public ResultDataHelper(UserService userService) {
        ResultDataHelper.userService = userService;
    }

    public static MoreLikeThisResponeDTO getMoreLikeThisResponse(List<ResultData> results){
        MoreLikeThisResponeDTO moreLikeThisResponeDTO = new MoreLikeThisResponeDTO();

        for(ResultData resultData: results){
            String recResult = resultData.getReviewers();
            if(recResult.contains(",")){
                String[] recenzentiIds = recResult.split(",");
                for(String recId: recenzentiIds){
                    UserDTO userDTO = userService.getOneUser(Long.parseLong(recId));
                    if(moreLikeThisResponeDTO.getReviewers().getUsers().stream().noneMatch(x->x.getUserId().equals(userDTO.getUserId())))
                        moreLikeThisResponeDTO.getReviewers().getUsers().add(userDTO);
                }
            }else{
                UserDTO userDTO = userService.getOneUser(Long.parseLong(recResult));
                if(moreLikeThisResponeDTO.getReviewers().getUsers().stream().noneMatch(x->x.getUserId().equals(userDTO.getUserId())))
                    moreLikeThisResponeDTO.getReviewers().getUsers().add(userDTO);
            }
            moreLikeThisResponeDTO.getResultData().add(resultData);
            moreLikeThisResponeDTO.getBookTitle().add(resultData.getTitle());
        }
        return moreLikeThisResponeDTO;
    }

    public static GeoSearchResponseDTO getGeoSearchResponse(List<ResultDataUser> resultDataUsers){
        GeoSearchResponseDTO geoSearchResponseDTO = new GeoSearchResponseDTO();

        for(ResultDataUser resultDataUser : resultDataUsers){
            if(resultDataUser.getUserRole().equals(RoleType.REVIEWER)){

                if(geoSearchResponseDTO.getUserListDTO().getUsers().stream().noneMatch(x->x.getUserId().equals(Long.parseLong(resultDataUser.getUserId())))){
                    UserDTO userDTO = userService.getOneUser(Long.parseLong(resultDataUser.getUserId()));
                    geoSearchResponseDTO.getUserListDTO().getUsers().add(userDTO);
                }
            }
        }
        geoSearchResponseDTO.setResultDataUsers(resultDataUsers);

        return geoSearchResponseDTO;
    }
}
