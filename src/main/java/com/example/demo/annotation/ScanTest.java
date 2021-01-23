package com.example.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

/**
 * @Author: likang
 * @Date: 2021/1/23 21:39
 */
@Component
public class ScanTest {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    protected ApplicationContext applicationContext;

    public void scantest() throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
        MetadataReaderFactory metaReader = new CachingMetadataReaderFactory(resourceLoader);
        Resource[] resources = resolver.getResources("classpath*:com/example/demo/annotation/*");

        for (Resource r : resources) {
            MetadataReader reader = metaReader.getMetadataReader(r);
            AnnotationMetadata annotationMetadata = reader.getAnnotationMetadata();

            Class<?> clz = Class.forName(annotationMetadata.getClassName());
            Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
            if (!CollectionUtils.isEmpty(annotationTypes)) {
                for (String annotationType : annotationTypes) {
                    //System.out.println(Link.class.getName());
                    if(Link.class.getName().equals(annotationType)){
                        System.out.println(clz.getAnnotation(Link.class).cmd());
                        Method[] methods = clz.getMethods();
                        for(Method method : methods){
                            if(method.isAnnotationPresent(LinkM.class)){
                                System.out.println(method.getAnnotation(LinkM.class).sub());
                                Object bean = applicationContext.getBean(clz);
                                method.invoke(bean);
                            }
                        }
                    }
                }
            }

            //System.out.println(reader.getClassMetadata().getClassName());
        }

    }
}
