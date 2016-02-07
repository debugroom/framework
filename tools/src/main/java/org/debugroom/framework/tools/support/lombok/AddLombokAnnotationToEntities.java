package org.debugroom.framework.tools.support.lombok;

import java.io.File;
import java.io.FilenameFilter;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;;

public class AddLombokAnnotationToEntities {

	public static void main(String[] args) throws Exception{
		
		Configuration configuration = new PropertiesConfiguration("META-INF/settings.properties");
		File entityClassDir = new File(configuration.getString("entityclass.filepath"));

		File[] entityClasses = entityClassDir.listFiles(
				(FilenameFilter)new WildcardFileFilter("*.java"));
		
		Boolean isAdded = false;
		List<String> sourceCodeList = null;
		List<String> newSourceCodeList = null;
		File newEntityClass = null;
		String injectionImportKeyword = configuration.getString("injection.import.keyword");
		String injectionAnnotationKeyword1 = configuration.getString("injection.annotation.keyword1");
		String injectionAnnotationKeyword2 = configuration.getString("injection.annotation.keyword2");

		for(File entityClass : entityClasses){

			sourceCodeList = FileUtils.readLines(entityClass, 
					configuration.getString("entityclass.read.encoding")); 
			newSourceCodeList = new ArrayList<String>();
			newEntityClass = new File(entityClass.getAbsolutePath());
			isAdded = false;

			for(String sourceCode : sourceCodeList){
				if("import lombok.AllArgsConstructor;".equals(sourceCode)){
					isAdded = true;
				}else if(!isAdded && injectionImportKeyword.equals(sourceCode)){
					newSourceCodeList.add("import lombok.AllArgsConstructor;");
					newSourceCodeList.add("import lombok.Builder;");
					newSourceCodeList.add("");
				}else if(!isAdded && (injectionAnnotationKeyword1.equals(sourceCode) 
						|| injectionAnnotationKeyword2.equals(sourceCode))){
					newSourceCodeList.add("@AllArgsConstructor");
					newSourceCodeList.add("@Builder");
				}
				newSourceCodeList.add(sourceCode);
			}

			FileUtils.writeLines(newEntityClass, 
					configuration.getString("entityclass.write.encoding"), 
					newSourceCodeList);
			
		}

	}

}
