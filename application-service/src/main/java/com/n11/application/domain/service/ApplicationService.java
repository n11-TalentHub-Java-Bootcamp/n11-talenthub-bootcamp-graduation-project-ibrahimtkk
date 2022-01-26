//package com.n11.application.domain.service;
//
//import com.n11.application.domain.service.kkb.KKBService;
//import com.n11.application.domain.service.user.UserService;
//import com.n11.application.infrastructure.acl.entity.User;
//import com.n11.application.infrastructure.acl.repository.UserRepository;
//import com.n11.application.infrastructure.exception.GatewayException;
//import com.n11.application.infrastructure.mapper.UserMapper;
//import com.n11.application.interfaces.request.ApplicationRequestDto;
//import com.n11.application.interfaces.response.ApplicationResponseDto;
//import io.vavr.control.Either;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ApplicationService implements ApplicationAppService{
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private KKBService kkbService;
//
//
////    public ApplicationService(final UserService userService) {
////        this.userService = userService;
////    }
//
//    @Override
//    public ApplicationResponseDto initiate(ApplicationRequestDto applicationRequestDto) {
//
//        final Integer kkbScore = kkbService.generateKKBScore(applicationRequestDto);
//        final User user = userService.save(applicationRequestDto, kkbScore);
//        final UserMapper userMapper = new UserMapper();
//        userMapper.
//
//
//    }
//}
