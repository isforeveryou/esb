package com.forever.consumer.dto;

/**
 * @author WJX
 * @date 2021/4/15 11:22
 */
public class Artist {

    private Integer age;

    private String name;

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
