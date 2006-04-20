package org.h3t.test.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratorType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(access=AccessType.FIELD)
public class A {
	
	@Id(generate=GeneratorType.AUTO)
	public Integer id;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public B b;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<B> bs = new LinkedList<B>();

}
