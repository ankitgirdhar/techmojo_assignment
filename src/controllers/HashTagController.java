package controllers;

import model.HashTag;

import java.util.*;

public class HashTagController {
    private HashMap<String, HashTag> hashtagMap;
    private TreeSet<HashTag> hashtagTreeSet;
    private static HashTagController INSTANCE;

    //initializing map and treeSet
    private HashTagController() {
        hashtagMap  = new HashMap<>();
        hashtagTreeSet = new TreeSet<HashTag>((a,b) -> {
            return (b.getFrequency() - a.getFrequency() == 0) ? a.getText().hashCode() - b.getText().hashCode() : b.getFrequency() - a.getFrequency();
        });
    }

    // making class singleton
    public static HashTagController getInstance() {
        if (INSTANCE == null)
            INSTANCE = new HashTagController();
        return INSTANCE;
    }


    //O(log(N))
    // updating/adding new hashtag in both treeset and hashmap
    public void addHashtag(String hashTagString) {
        HashTag hashtagReference;
        if(hashtagMap.containsKey(hashTagString)){
            hashtagReference = hashtagMap.get(hashTagString);
            hashtagTreeSet.remove(hashtagReference);
            hashtagReference.setFrequency(hashtagReference.getFrequency() + 1);
        } else {
            hashtagReference = new HashTag(hashTagString,1);
            hashtagMap.put(hashTagString,hashtagReference);
        }
        hashtagTreeSet.add(hashtagReference);


    }

    //O(10) constant
    public ArrayList<String> getTopTenHashtags() {
        ArrayList<String> topTenTags = new ArrayList<String>();
        for(HashTag tag : hashtagTreeSet) {
            if(!topTenTags.contains(tag.getText()))
                topTenTags.add(tag.getText());
            if(topTenTags.size()==10)
                break;
        }
        return topTenTags;
    }

    public int getHashTagFrequency(String hashtag) {
        return hashtagMap.get(hashtag).getFrequency();
    }

    public HashMap<String, HashTag> getHashtagMap() {
        return hashtagMap;
    }

    public void setHashtagMap(HashMap<String, HashTag> hashtagMap) {
        this.hashtagMap = hashtagMap;
    }

    public TreeSet<HashTag> getHashtagTreeSet() {
        return hashtagTreeSet;
    }

    public void setHashtagTreeSet(TreeSet<HashTag> hashtagTreeSet) {
        this.hashtagTreeSet = hashtagTreeSet;
    }
}
