package service;

import java.util.List;

import org.hibernate.Session;

import model.ReciteLog;
import model.Word;


public interface Manager {
	public void addLogToWord(ReciteLog rl, int id);
	public Word getWord(int id);
	public List<Word> getWords(int count);
	public void saveWord(Word word);
	public void saveWord(Word word[]);
	public void saveReciteLog(ReciteLog rl,Word word);
	public void saveReciteLog(ReciteLog []rl,Word word);
	void saveReciteLog(ReciteLog rl, String wordContent);
	List<ReciteLog> getLogs(int id);
}
