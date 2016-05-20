package cz.venglarjakub.ppj.pictures.controller;

import cz.venglarjakub.ppj.pictures.domain.Comment;
import cz.venglarjakub.ppj.pictures.domain.Picture;
import cz.venglarjakub.ppj.pictures.domain.Tag;
import cz.venglarjakub.ppj.pictures.service.CommentService;
import cz.venglarjakub.ppj.pictures.service.PictureService;
import cz.venglarjakub.ppj.pictures.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Jakub Venglar on 25. 4. 2016.
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/pictures", method = RequestMethod.GET)
    public String pictures(Model model) {
        model.addAttribute("name", "kuba");
        model.addAttribute("picture", new Picture());

        return "greeting";
    }

    @RequestMapping(value = "/pictures/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Picture picture, Model model) {
        System.out.println(picture.getName());
        System.out.println("ukladam");
        return "redirect:/pictures";
    }

    @RequestMapping(value = "/pictures/{id}", method = RequestMethod.GET)
    public String pictures(@PathVariable BigInteger id, Model model) {
        model.addAttribute("current", id);
        model.addAttribute("next", -1);
        model.addAttribute("previous", -1);
        model.addAttribute("picture", new Picture());
        model.addAttribute("comments", new ArrayList<Comment>());
        model.addAttribute("tags", new ArrayList<Tag>());

        Picture nextPicture = pictureService.getNextById(id);
        if (nextPicture != null) {
            model.addAttribute("next", nextPicture.getId());
        }

        Picture previousPicture = pictureService.getPreviousById(id);
        if (previousPicture != null) {
            model.addAttribute("previous", previousPicture.getId());
        }

        Picture currentPicture = pictureService.getById(id);
        if (currentPicture != null) {
            model.addAttribute("picture", currentPicture);
            model.addAttribute("comments", commentService.getByPicture(currentPicture));
            model.addAttribute("tags", tagService.getByPicture(currentPicture));
        }

        model.addAttribute("name", "kuba");

        return "greeting";
    }

    @RequestMapping(value = "/pictures/{id}/like", method = RequestMethod.GET)
    public String like(@PathVariable BigInteger id, Model model) {
        pictureService.like(id);
        return "redirect:/pictures/" + id;
    }

    @RequestMapping(value = "/pictures/{id}/dislike", method = RequestMethod.GET)
    public String dislike(@PathVariable BigInteger id, Model model) {
        pictureService.dislike(id);
        return "redirect:/pictures/" + id;
    }

    @RequestMapping(value = "/pictures/{id}/comments/{comment}/like", method = RequestMethod.GET)
    public String likeComment(@PathVariable BigInteger id, @PathVariable BigInteger comment, Model model) {
        commentService.like(comment);
        return "redirect:/pictures/" + id;
    }

    @RequestMapping(value = "/pictures/{id}/comments/{comment}/dislike", method = RequestMethod.GET)
    public String dislikeComment(@PathVariable BigInteger id, @PathVariable BigInteger comment, Model model) {
        commentService.dislike(comment);
        return "redirect:/pictures/" + id;
    }

}
