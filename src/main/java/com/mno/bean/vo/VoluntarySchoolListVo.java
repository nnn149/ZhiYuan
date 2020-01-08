/**
 * FileName: VoluntarySchoolListVo
 * Author:   10418
 * Date:     2020-01-06 22:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.bean.vo;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-06
 * @since 1.0.0
 */
public class VoluntarySchoolListVo {
    private int id;
    private String nickname;
    private String username;
    private String remark;
    private int mathScore;
    private int englishScore;
    private int majorScore;
    private int totalScore;
    private int rank;
    private String speciality;
    private boolean tiaoji;
    private String zhiyuan;
    private String status;

    public VoluntarySchoolListVo() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTiaoji() {
        return tiaoji;
    }

    public void setTiaoji(boolean tiaoji) {
        this.tiaoji = tiaoji;
    }

    public String getZhiyuan() {
        return zhiyuan;
    }

    public void setZhiyuan(String zhiyuan) {
        this.zhiyuan = zhiyuan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getMajorScore() {
        return majorScore;
    }

    public void setMajorScore(int majorScore) {
        this.majorScore = majorScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
