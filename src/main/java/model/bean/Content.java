package model.bean;


public class Content {
	private int id;
	private String title;
	private String brief;
	private String content;
	private String createString;
	private String updatetime;
	private int authorId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateString() {
		return createString;
	}
	public void setCreateString(String createString) {
		this.createString = createString;
	}
	public String getupdatetime() {
		return updatetime;
	}
	public void setupdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public Content(int id, String title, String brief, String content, String createString, String updatetime, int authorId) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createString = createString;
		this.updatetime = updatetime;
		this.authorId = authorId;
	}
	public Content() {
		super();
	}
	

}
