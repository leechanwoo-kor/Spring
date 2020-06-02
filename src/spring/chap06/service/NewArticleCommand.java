package spring.chap06.service;

public class NewArticleCommand {
	
	private String title;
	private String content;
	private int perentId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPerentId() {
		return perentId;
	}
	public void setPerentId(int perentId) {
		this.perentId = perentId;
	}
	
	@Override
	public String toString() {
		return "NewArticleCommand [content=" + content + ", parentId=" + perentId + ", title=" + title + "]";
	}
}
