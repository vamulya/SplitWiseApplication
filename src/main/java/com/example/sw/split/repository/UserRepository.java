package com.example.sw.split.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sw.split.model.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long>{
	
User findByUsername(String username);

@Query(value="select username from user_table",nativeQuery=true)
public ArrayList<String> findUsers();

@Modifying
@Query(value="insert into split_table(splitid,name,friend_name,owed,date) values(:splitid,:name,:friend_name,:owed,:date)",nativeQuery=true)
public void insertNewSplit(@Param("splitid") int splitid,@Param("friend_name") String friend_name,@Param("owed") float owed,@Param("name") String name,@Param("date") String date);

@Modifying
@Query(value="insert into balance_table(splitid,name,tot_bal_owed) values(:splitid,:name,:tot_bal_owed)",nativeQuery=true)
public void insertNewBalRecord(@Param("splitid") int splitid,@Param("name") String name,@Param("tot_bal_owed") float tot_bal_owed);


@Query(value="select tot_bal_owed from balance_table where name=:name",nativeQuery=true)
public String getExistingAmount(@Param("name") String name);

@Query(value="select splitid from split_table where splitid=:splitid",nativeQuery=true)
public String getSplitId(@Param("splitid") int splitid);

@Modifying
@Query(value="delete from balance_table where name=:name",nativeQuery=true)
public void deleteExistingRecord(@Param("name") String name);

//@Query(value="select distinct(name) from balance_table where tot_bal_owed>0",nativeQuery=true)
@Query(value="select distinct(st.friend_name) from split_table st,balance_table bt where st.name=:loggedUser and st.splitid=bt.splitid and bt.tot_bal_owed>0",nativeQuery=true)
public ArrayList<String> getFriendsForSettleUp(@Param("loggedUser") String loggedUser);

@Modifying
@Query(value="update balance_table set tot_bal_owed=:remaining_bal where name=:name",nativeQuery=true)
public void updateBalForSettleUp(@Param("remaining_bal") float remaining_bal,@Param("name") String name);



}

	