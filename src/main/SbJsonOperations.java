package main;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import com.google.gson.*;
import main.SbGetLevenshteinDistance;

public class SbJsonOperations {

	public Map<String, String[]> map = new HashMap<String,String[]>();
	public Map<String, String[]> mapForCalculation = new HashMap<String,String[]>();
	public Map<String, String> mapWithResults = new HashMap<String,String>();

	protected String answer1;
	protected String answer2;
	protected String answer3;
	protected String answer4;
	protected String answer5;
	protected String name;	
	protected String surrname;
	protected Double score = 0.0;
	public List<String> outputList = new ArrayList<String>();	

	public void createPool() throws IOException
	{						
		map.put("kot", new String[] {"cat","puss","feline"});
		map.put("pies", new String[] {"dog","pooch","cur"});
		map.put("lubic", new String[] {"like","love","enjoy"});
		map.put("samolot", new String[] {"plane","kite","aircraft"});
		map.put("samochod", new String[] {"car","automobile","auto"});
		map.put("kula", new String[] {"ball","sphere","bullet"});
		map.put("piorun", new String[] {"thunderbolt","lightning"});
		map.put("zwierze", new String[] {"animal","beast"});
		map.put("mapa", new String[] {"map","chart"});
		map.put("spacer", new String[] {"walk","stroll","wander"});
		
		mapForCalculation.put("kot", new String[] {"cat","puss","feline"});
		mapForCalculation.put("pies", new String[] {"dog","pooch","cur"});
		mapForCalculation.put("lubic", new String[] {"like","love","enjoy"});
		mapForCalculation.put("samolot", new String[] {"plane","kite","aircraft"});
		mapForCalculation.put("samochod", new String[] {"car","automobile","auto"});
		mapForCalculation.put("kula", new String[] {"ball","sphere","bullet"});
		mapForCalculation.put("piorun", new String[] {"thunderbolt","lightning"});
		mapForCalculation.put("zwierze", new String[] {"animal","beast"});
		mapForCalculation.put("mapa", new String[] {"map","chart"});
		mapForCalculation.put("spacer", new String[] {"walk","stroll","wander"});

		// create a writer
		Writer writer = Files.newBufferedWriter(Paths.get("PolEngTest.json"));

	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    
	    gson.toJson(map, writer);

	    writer.close();
	}
	
	public boolean loadMapFromJson()
	{
		map.clear();
		try {
		    Gson gson = new Gson();

		    Reader reader = Files.newBufferedReader(Paths.get("PolEngTest.json"));

		    map = gson.fromJson(reader, Map.class);

//		    // print map entries
//		    for (Map.Entry<?, ?> entry : map.entrySet()) {
//		        System.out.println(entry.getKey() + "=" + entry.getValue());
//		    }

		    reader.close();
		    
		    return true;

		} catch (Exception ex) {
		    ex.printStackTrace();
		    return false;
		}

	}
	
	public List<String> getRandomQuestionList()
	{
		if(!map.isEmpty())
		{
			Random rand = new Random();
			List<String> lWordList = new ArrayList<String>(map.keySet());

				for(int i = 0; i < 5; i ++)
				{					
					int randomIndex = rand.nextInt(lWordList.size());
					outputList.add(lWordList.get(randomIndex));
					lWordList.remove(randomIndex);					
				}
				return outputList;
		}else
		{
			return null;
		}		
	}
	
	public void calculateScore()
	{
		calculateScoreForAnswer1();
		calculateScoreForAnswer2();
		calculateScoreForAnswer3();
		calculateScoreForAnswer4();
		calculateScoreForAnswer5();
	}
	
	private void calculateScoreForAnswer1()
	{
		score = 0.0;
		String[] answerToWord = mapForCalculation.get(outputList.get(0));
		List<String> lAnswerList = Arrays.asList(answerToWord);
		for (int i = 0; i < lAnswerList.size(); i++)
		{
			if(SbGetLevenshteinDistance.getLevDist(answer1,lAnswerList.get(i)) == 0)
					{
						score++;
						return;
					}else if(SbGetLevenshteinDistance.getLevDist(answer1,lAnswerList.get(i)) == 1)
					{
						score += 0.5;
						return;
					}
		}		
	}
	private void calculateScoreForAnswer2()
	{
		String[] answerToWord = mapForCalculation.get(outputList.get(1));
		List<String> lAnswerList = Arrays.asList(answerToWord);
		for (int i = 0; i < lAnswerList.size(); i++)
		{
			if(SbGetLevenshteinDistance.getLevDist(answer2,lAnswerList.get(i)) == 0)
					{
						score++;
						return;
					}else if(SbGetLevenshteinDistance.getLevDist(answer2,lAnswerList.get(i)) == 1)
					{
						score += 0.5;
						return;
					}
		}		
	}
	
	private void calculateScoreForAnswer3()
	{
		String[] answerToWord = mapForCalculation.get(outputList.get(2));
		List<String> lAnswerList = Arrays.asList(answerToWord);
		for (int i = 0; i < lAnswerList.size(); i++)
		{
			if(SbGetLevenshteinDistance.getLevDist(answer3,lAnswerList.get(i)) == 0)
					{
						score++;
						return;
					}else if(SbGetLevenshteinDistance.getLevDist(answer3,lAnswerList.get(i)) == 1)
					{
						score += 0.5;
						return;
					}
		}		
	}
	
	private void calculateScoreForAnswer4()
	{
		String[] answerToWord = mapForCalculation.get(outputList.get(3));
		List<String> lAnswerList = Arrays.asList(answerToWord);
		for (int i = 0; i < lAnswerList.size(); i++)
		{
			if(SbGetLevenshteinDistance.getLevDist(answer4,lAnswerList.get(i)) == 0)
					{
						score++;
						return;
					}else if(SbGetLevenshteinDistance.getLevDist(answer4,lAnswerList.get(i)) == 1)
					{
						score += 0.5;
						return;
					}
		}		
	}
	
	private void calculateScoreForAnswer5()
	{
		String[] answerToWord = mapForCalculation.get(outputList.get(4));
		List<String> lAnswerList = Arrays.asList(answerToWord);
		for (int i = 0; i < lAnswerList.size(); i++)
		{
			if(SbGetLevenshteinDistance.getLevDist(answer5,lAnswerList.get(i)) == 0)
					{
						score++;
						return;
					}else if(SbGetLevenshteinDistance.getLevDist(answer5,lAnswerList.get(i)) == 1)
					{
						score += 0.5;
						return;
					}
		}		
	}
	
	public void saveResultToJson(double elapsedTime) throws IOException
	{
		mapWithResults = createResultMap();
		mapWithResults.put("YOUR SCORE:", String.valueOf(score));
		mapWithResults.put("Time Elapsed:", String.valueOf(elapsedTime));
		
		
		// create a writer
		if(name.isBlank())
		{
			name = "Brak";
		}
		
		if(surrname.isBlank())
		{
			name = "Brak";
		}
				Writer writer = Files.newBufferedWriter(Paths.get(name + "_" + surrname + ".json"));

			    Gson gson = new GsonBuilder().setPrettyPrinting().create();
			    
			    gson.toJson(mapWithResults, writer);

			    writer.close();
		
	}
	private Map<String,String> createResultMap()
	{
		Map<String,String> lMap = new HashMap<String,String>();
		lMap.put(outputList.get(0), answer1);
		lMap.put(outputList.get(1), answer2);
		lMap.put(outputList.get(2), answer3);
		lMap.put(outputList.get(3), answer4);
		lMap.put(outputList.get(4), answer5);
		return lMap;
	}
	
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setSurrname(String surrname) {
		this.surrname = surrname;
	}

	public Map<String, String[]> getMapForCalculation() {
		return mapForCalculation;
	}

	public Map<String, String> getMapWithResults() {
		return mapWithResults;
	}

	public String getAnswer1() {
		return answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public String getAnswer5() {
		return answer5;
	}

	public String getName() {
		return name;
	}

	public String getSurrname() {
		return surrname;
	}

	public Double getScore() {
		return score;
	}
	
	public Map<String, String[]> getMap() {
		return map;
	}
	
	public List<String> getOutputList() {
		return outputList;
	}
}
