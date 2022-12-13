package fudan.pm.fudanCompass.controller;


import fudan.pm.fudanCompass.Utils.JsonResult;
import fudan.pm.fudanCompass.dto.ArticleOutputDto;
import fudan.pm.fudanCompass.dto.RatingOutputDto;
import fudan.pm.fudanCompass.dto.request.SetUserMajorRequest;
import fudan.pm.fudanCompass.dto.request.UserDetailsRequest;
import fudan.pm.fudanCompass.dto.request.UserTimeTableRequest;
import fudan.pm.fudanCompass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/getUserFavourArticles")
    public List<ArticleOutputDto> getFavourArticles(@RequestBody Long id) throws Exception {
        return userService.getFavourArticles(id);
    }

    @PostMapping("/getUserFavourRatings")
    public List<RatingOutputDto> getFavourRatings(@RequestBody Long id) throws Exception {
        return userService.getFavourRatings(id);
    }

    @PostMapping("/setUserMajor")
    public void setUserMajor(@RequestBody SetUserMajorRequest request) throws Exception {
        userService.setUserMajor(request);
    }

    @PostMapping("/getUserMajor")
    public JsonResult<?> getUserMajor(@RequestBody UserDetailsRequest userDetailsRequest) throws Exception {
        return new JsonResult<>(userService.getUserMajor(userDetailsRequest.getUserId()));
    }

    @PostMapping("/getInfo")
    public JsonResult<?> getInfo(@RequestBody UserDetailsRequest request){
        System.out.println("getInfo");
        HashMap hashMap = userService.getInfo(request.getUserId());
        return new JsonResult<>(hashMap);
    }
    @PostMapping("/getUserTimeTableByDay")
    public JsonResult<?> getUserTimeTableByDay(@RequestBody UserTimeTableRequest userTimeTableRequest){
        HashMap hashMap = userService.getUserTimeTableByDay(userTimeTableRequest.getDay(), userTimeTableRequest.getUserId());
        return new JsonResult<>(hashMap);
    }
    @PostMapping("setUserTimeTableByDay")
    public JsonResult<?> setUserTimeTableByDay(@RequestBody UserTimeTableRequest userTimeTableRequest){
        HashMap hashMap = userService.setUserTimeTableByDay(userTimeTableRequest.getDay(),userTimeTableRequest.getUserId(),userTimeTableRequest.getCourses());
        return new JsonResult<>(hashMap);
    }
}
