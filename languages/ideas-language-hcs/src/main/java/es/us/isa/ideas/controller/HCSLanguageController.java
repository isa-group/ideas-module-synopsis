package es.us.isa.ideas.controller;

import es.us.isa.ideas.module.common.AppResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.us.isa.ideas.module.controller.BaseLanguageController;
import es.us.isa.ideas.synopsis.common.AnalyzeDelegate;
import es.us.isa.ideas.synopsis.common.ConversionDelegate;
import es.us.isa.ideas.synopsis.common.LanguageDelegate;

@Controller
@RequestMapping("/language")
public class HCSLanguageController extends BaseLanguageController {

    @RequestMapping(value = "/operation/{id}/execute", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public AppResponse executeOperation(String id, String content, String fileUri, String auxArg0) {

        return AnalyzeDelegate.analize(id, content, fileUri, auxArg0);
    }

    @RequestMapping(value = "/format/{format}/checkLanguage", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public AppResponse checkLanguage(String id, String content, String fileUri) {

        return LanguageDelegate.checkLanguage(id, content, fileUri, false);
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public AppResponse convertFormat(String currentFormat, String desiredFormat, String fileUri, String content) {

        return ConversionDelegate.convert(currentFormat, desiredFormat,
                fileUri, content);
    }
}
