package com.mrbird.web.controller;

import com.mrbird.common.annotation.Log;
import com.mrbird.common.controller.BaseController;
import com.mrbird.common.domain.ResponseBo;
import com.mrbird.common.util.FebsConstant;
import com.mrbird.common.util.HttpUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MovieController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Log("获取热门电影信息")
    @RequestMapping("movie/hot")
    @RequiresPermissions("movie:hot")
    public String movieHot() {
        return "web/movie/hot";
    }

    @Log("获取即将上映电影信息")
    @RequestMapping("movie/coming")
    @RequiresPermissions("movie:coming")
    public String movieComing() {
        return "web/movie/coming";
    }

    @RequestMapping("movie/getMovieHot")
    @ResponseBody
    public ResponseBo getMoiveHot() {
        try {
            String data = HttpUtils.sendSSLPost(FebsConstant.TIME_MOVIE_HOT_URL, "locationId=328");
            return ResponseBo.ok(data);
        } catch (Exception e) {
            logger.error("获取热映影片信息失败", e);
            return ResponseBo.error("获取热映影片信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("movie/getMovieComing")
    @ResponseBody
    public ResponseBo getMovieComing() {
        try {
            String data = HttpUtils.sendSSLPost(FebsConstant.TIME_MOVIE_COMING_URL, "locationId=328");
            return ResponseBo.ok(data);
        } catch (Exception e) {
            logger.error("获取即将上映影片信息失败", e);
            return ResponseBo.error("获取即将上映影片信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("movie/detail")
    @ResponseBody
    public ResponseBo getDetail(String id) {
        try {
            String data = HttpUtils.sendSSLPost(FebsConstant.TIME_MOVIE_DETAIL_URL, "locationId=328&movieId=" + id);
            return ResponseBo.ok(data);
        } catch (Exception e) {
            logger.error("获取影片详情失败", e);
            return ResponseBo.error("获取影片详情失败，请联系网站管理员！");
        }
    }

    @RequestMapping("movie/comments")
    @ResponseBody
    public ResponseBo getComments(String id) {
        try {
            String data = HttpUtils.sendSSLPost(FebsConstant.TIME_MOVIE_COMMENTS_URL, "movieId=" + id);
            return ResponseBo.ok(data);
        } catch (Exception e) {
            logger.error("获取影片评论失败", e);
            return ResponseBo.error("获取影片评论失败，请联系网站管理员！");
        }
    }
}
