package model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Word {
	private int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private String word;
	private String paraphrase;
	private int id;

	private List<ReciteLog> log=new ArrayList<ReciteLog>();
	public Word(){		
	};
	public Word(String word,String paraphrase){
		this.word=word;
		this.paraphrase=paraphrase;
		this.type=0;
	}
	public Word(String word,String paraphrase,int type){
		this.word=word;
		this.paraphrase=paraphrase;
		this.type=type;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getParaphrase() {
		return paraphrase;
	}
	public void setParaphrase(String paraphrase) {
		this.paraphrase = paraphrase;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="log")
	public List<ReciteLog> getLog() {
		return log;
	}
	public void setLog(List<ReciteLog> log) {
		this.log = log;
	}

}
