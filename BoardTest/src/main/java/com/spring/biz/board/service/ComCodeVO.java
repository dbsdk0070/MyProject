package com.spring.biz.board.service;

public class ComCodeVO {
	private String codetype, codeid, codename, creator,
				   createtime, modifier, modifiedtime;

	public ComCodeVO() {
		
	}

	public String getCodetype() {
		return codetype;
	}

	public void setCodetype(String codetype) {
		this.codetype = codetype;
	}

	public String getCodeid() {
		return codeid;
	}

	public void setCodeid(String codeid) {
		this.codeid = codeid;
	}

	public String getCodename() {
		return codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	@Override
	public String toString() {
		return "ComCodeVO [codetype=" + codetype + ", codeid=" + codeid + ", codename=" + codename + ", creator="
				+ creator + ", createtime=" + createtime + ", modifier=" + modifier + ", modifiedtime=" + modifiedtime
				+ "]";
	}

	
	
}