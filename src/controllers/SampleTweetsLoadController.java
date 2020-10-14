package controllers;

import java.io.*;

public class SampleTweetsLoadController {


    public void loadSampleTweets() {
        HashTagController hashTagController = HashTagController.getInstance();

        //reading from the file
        File file = new File("src/data/sample_tweets.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while(line!= null)  {
                String[] s = line.split(" ");
                for(String str : s) {
                    if(str.charAt(0) == '#') {
                        if(str.charAt(str.length()-1) == '.')
                            str = str.substring(0,str.length()-1);
                        hashTagController.addHashtag(str);
                    }
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
