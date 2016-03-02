package org.debugroom.framework.tools.support.jpa;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;;

public class AddVersionAnnotationToEntities {

	public static void main(String[] args) throws Exception {

		Configuration configuration = new PropertiesConfiguration("META-INF/settings.properties");
		File entityClassDir = new File(configuration.getString("entityclass.filepath"));

		File[] entityClasses = entityClassDir.listFiles(
				(FilenameFilter)new WildcardFileFilter("*.java"));

		String injectionAnnotationKeyword1 = configuration.getString("jpa.version.annotation.injection.annotation.keyword1");
		String injectionAnnotationKeyword2 = configuration.getString("jpa.version.annotation.injection.annotation.keyword2");
		Boolean isAdded = false;
			
		List<String> sourceCodeList = null;
		List<String> newSourceCodeList = null;
		File newEntityClass = null;

		for(File entityClass : entityClasses){

			sourceCodeList = FileUtils.readLines(entityClass, 
					configuration.getString("entityclass.read.encoding")); 
			newSourceCodeList = new ArrayList<String>();
			newEntityClass = new File(entityClass.getAbsolutePath());
			isAdded = false;

			for(String sourceCode : sourceCodeList){
				if(injectionAnnotationKeyword2.equals(sourceCode)){
					isAdded = true;
				}else if(!isAdded && injectionAnnotationKeyword1.equals(sourceCode)){
					newSourceCodeList.add("\t@Version");
				}
				newSourceCodeList.add(sourceCode);
			}

			FileUtils.writeLines(newEntityClass, 
					configuration.getString("entityclass.write.encoding"), 
					newSourceCodeList);
		}

	}

}
