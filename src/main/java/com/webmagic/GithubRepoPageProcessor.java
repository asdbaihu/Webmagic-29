package com.webmagic;

import java.util.Date;
import java.util.List;

import org.apache.commons.io.output.ThresholdingOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class GithubRepoPageProcessor implements PageProcessor {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    @Override
    public void process(Page page) {
    	logger.info(page.getUrl().get());
//    	logger.info(page.toString());
    	List<String> selectable = page.getHtml().links().all();
        logger.info(selectable.toString());
    	page.addTargetRequests(selectable);
        /*page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-])").all());*/
//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
/*        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }*/
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
        page.putField("date", new Date());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        
    }
}