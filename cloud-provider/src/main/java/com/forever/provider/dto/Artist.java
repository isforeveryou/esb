package com.forever.provider.dto;

/**
 * @author WJX
 * @date 2021/4/15 11:22
 */
public class Artist {

    private Integer age;

    private String name;

    public Artist() {}

    public Artist(Integer age, String name) {
        this.age = age; this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
