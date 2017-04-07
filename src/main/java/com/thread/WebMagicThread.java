package com.thread;

import com.webmagic.GithubRepoPageProcessor;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

public class WebMagicThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://blog.csdn.net/")
		.addPipeline(new JsonFilePipeline("/opt/file/webmagictest")).thread(1).run();
	}

}
