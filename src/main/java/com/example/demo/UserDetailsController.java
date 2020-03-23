package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

  //  @CrossOrigin(origins="http://localhost:3000",maxAge = 3600)
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RestController
    public class UserDetailsController {
        @Autowired
        UserDetailsRepository userRepository;

        @GetMapping("/users")
           public ApiResponse<List<UserDetails>> getAllUsers(){
//            return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userRepository.findAll());
            return new ApiResponse<>(userRepository.findAll());
        }
/*      public List<UserDetails> getAllUsers() {
          return userRepository.findAll();
      } */



      @GetMapping("/users/{user_id}")
      public Optional<UserDetails> getAllUsersById(@PathVariable(value = "user_id") Integer user_id) {
          return userRepository.findById(user_id);
      }

        @PostMapping("/users")
        public @Valid UserDetails createUser(@Valid @RequestBody UserDetails userDetails) {
            return userRepository.save(userDetails);
        }

      @PutMapping("/users/{user_id}")
      public @Valid UserDetails UpdateUser(@PathVariable(value = "user_id") Integer user_id, @Valid @RequestBody UserDetails userDetails)
              throws UserNotFoundException {
         UserDetails usr = userRepository.findById(user_id).orElseThrow(() -> new UserNotFoundException(user_id));
          usr.setFirst_name(userDetails.getFirst_name());
          usr.setLast_name(userDetails.getLast_name());
          userDetails.setMiddle_name((userDetails.getMiddle_name()));
          userDetails.setEmail(userDetails.getEmail());
          userDetails.setMobile_number(userDetails.getMobile_number());
          userDetails.setPassword(userDetails.getPassword());
          UserDetails updUser = userRepository.save(usr);
          return updUser;
      }
      @DeleteMapping("/users/{user_id}")
      public ResponseEntity<?> deleteUser(@PathVariable(value = "user_id") int user_id) throws UserNotFoundException {
          UserDetails usr1 = userRepository.findById(user_id)
                  .orElseThrow(() -> new UserNotFoundException(user_id));

          userRepository.delete(usr1);

          return ResponseEntity.ok().build();
      }

  }



