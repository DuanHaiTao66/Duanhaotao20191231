package com.bawei.duanhaotao.bean;
/*
 *@auther:段海涛
 *@Date: 2019-12-31
 *@Time:9:16
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class Bean {

    private List<RankingBean> ranking;

    public List<RankingBean> getRanking() {
        return ranking;
    }

    public void setRanking(List<RankingBean> ranking) {
        this.ranking = ranking;
    }

    public static class RankingBean {


        private String avatar;
        private String name;
        private String rank;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }
    }
}
