package com.example.gen.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import java.time.LocalDate;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 
    * </p>
*
* @author slz
* @since 2019-11-02
*/
    public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    private String sname;

    private LocalDate borndate;

        public Integer getSid() {
        return sid;
        }

            public void setSid(Integer sid) {
        this.sid = sid;
        }
        public String getSname() {
        return sname;
        }

            public void setSname(String sname) {
        this.sname = sname;
        }
        public LocalDate getBorndate() {
        return borndate;
        }

            public void setBorndate(LocalDate borndate) {
        this.borndate = borndate;
        }

    @Override
    protected Serializable pkVal() {
        return this.sid;
    }

    @Override
    public String toString() {
    return "Student{" +
            "sid=" + sid +
            ", sname=" + sname +
            ", borndate=" + borndate +
    "}";
    }
}
