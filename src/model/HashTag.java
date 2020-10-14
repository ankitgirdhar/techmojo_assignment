package model;


import java.util.Objects;

public class HashTag {
    private String text;
    private Integer frequency;

    public HashTag(String text, Integer frequency) {
        this.text = text;
        this.frequency = frequency;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashTag)) return false;
        HashTag hashTag = (HashTag) o;
        return Objects.equals(getText(), hashTag.getText()) &&
                Objects.equals(getFrequency(), hashTag.getFrequency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getText(), getFrequency());
    }
}
