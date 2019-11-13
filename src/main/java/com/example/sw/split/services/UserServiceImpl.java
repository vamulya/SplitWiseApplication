package com.example.sw.split.services;

import java.util.ArrayList;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sw.split.model.User;
import com.example.sw.split.repository.UserRepository;


@Service
@Transactional
public class UserServiceImpl {

	

		@Autowired
		private UserRepository userRepository;
		
		public void save(User user) {
			userRepository.save(user);
			
		}
		
		

		public User findByUsername(String username) {
			return userRepository.findByUsername(username);
		}
		
		public ArrayList<String> findUsers(){
			return userRepository.findUsers();
		}
		
		public void insertNewSplit(int splitid,String friend_name,float owed,String loggedUser,String date) {
			 userRepository.insertNewSplit(splitid,friend_name, owed, loggedUser,date);
		}
		public void insertNewBalRecord(int splitid,String name,float tot_bal_owed) {
			 userRepository.insertNewBalRecord(splitid,name, tot_bal_owed);
		}

		public String getExistingAmount(String name) {
			return userRepository.getExistingAmount(name);
		}
		
		public String getSplitId(int splitid) {
			return userRepository.getSplitId(splitid);
		}
		
		public void deleteExistingRecord(String name) {
			 userRepository.deleteExistingRecord(name);
		}
		
	    public ArrayList<String> getFriendsForsettleUp(String loggedUser){
	    	return userRepository.getFriendsForSettleUp(loggedUser);
	    }
	    
	    
	    public void updateBalForSettleUp(float remaining_bal,String name) {
	    	 userRepository.updateBalForSettleUp(remaining_bal, name);
	    }
	}
	
	

