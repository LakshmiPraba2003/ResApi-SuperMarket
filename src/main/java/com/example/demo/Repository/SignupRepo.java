package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Signup;

public interface SignupRepo extends JpaRepository<Signup, Integer>{
	@Query(value = "select Case from Signup where emailid=:ns and password=:s",nativeQuery = true)
	boolean getsignup(@Param("ns") String emailid,@Param("s") String password);
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Signup c WHERE c.emailid = :email and c.password=:pass")
    boolean existsByName(@Param("email") String email,@Param("pass") String pass);
}
