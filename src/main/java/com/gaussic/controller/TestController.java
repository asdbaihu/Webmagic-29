package com.gaussic.controller;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thread.WebMagicThread;
import com.webmagic.GithubRepoPageProcessor;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return "test";
	}
	
	@PostConstruct
	public void initWebMagic(){
		Executor executor = Executors.newFixedThreadPool(10);
		executor.execute(new WebMagicThread());
	}
}
