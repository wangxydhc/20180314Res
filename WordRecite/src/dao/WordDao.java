package dao;

import java.util.List;

import org.hibernate.Session;

import model.Word;

public interface WordDao {
	public  Word getWord(int id);
	public  Word getWord(String content);
	public  List<Word> getWordArrays(int count);
	public  boolean saveWord(Word w);
	public void setSession(Session session);
	boolean exist(String content);
	Word getByContent(String content);
}
