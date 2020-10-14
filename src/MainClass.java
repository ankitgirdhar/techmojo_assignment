import controllers.HashTagController;
import controllers.SampleTweetsLoadController;

import java.io.*;

public class MainClass {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashTagController hashTagController = HashTagController.getInstance();
        boolean isSampleDataLoaded = false,isProgramRunning = true;
        while(isProgramRunning) {
            System.out.println("********************************");
            System.out.println("Select choice number from below:");
            System.out.println("Load Sample Tweets: [1]");
            System.out.println("Add new Tweet: [2]");
            System.out.println("Get Top Ten Trending Tweets: [3]");
            System.out.println("Exit: [4]");
            System.out.print(">");
            int choice=5;
            try {
                choice = Integer.parseInt(br.readLine().split(" ")[0]);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }


            switch (choice) {
                case 1:
                    if(isSampleDataLoaded)
                        System.out.println("Sample tweets already loaded!");
                    else {
                        SampleTweetsLoadController sampleTweetsLoadController = new SampleTweetsLoadController();
                        sampleTweetsLoadController.loadSampleTweets();
                        isSampleDataLoaded = true;
                        System.out.println("Tweets loaded successfully!");
                    }
                    break;
                case 2:
                    System.out.println("Enter a tweet below:");
                    System.out.print(">");
                    String[] line = br.readLine().split(" ");
                    for(String word : line) {
                        if(word.charAt(0) == '#') {
                            if(word.charAt(word.length()-1) == '.')
                                word = word.substring(0,word.length()-1);
                            hashTagController.addHashtag(word);
                        }
                    }
                    break;
                case 3:
                    System.out.println("The trending hashtags are:");
                    System.out.println(hashTagController.getTopTenHashtags());
                    break;
                case 4:
                    isProgramRunning=false;
                    break;
                default:
                    System.out.println("Enter a valid choice");


            }

        }
        System.out.println("Program Ended.");

    }
}
