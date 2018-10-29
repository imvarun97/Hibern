package com.caps.dev.Dao;

import com.caps.dev.beans.Person;

public interface PersonInterface {
	public void create(Person p);
	public void update(Person p);
	public void search(Person p);
	public void delete(Person p);

}
