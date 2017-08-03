package com.company.niuke;

/**
 * Created by a1996_000 on 2017/8/1.
 */
//生产人的工厂
public class PeopleFactory {
    /**
     *生产人的工厂
     * @return
     */
    public People createPeople(){
        return new People();
    }
}
