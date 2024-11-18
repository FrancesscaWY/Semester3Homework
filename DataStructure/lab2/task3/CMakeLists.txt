cmake_minimum_required(VERSION 3.29)
project(task3)


set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set( CMAKE_BUILD_TYPE "Release" )
set( CMAKE_CXX_FLAGS "-std=c++17 -O3")

include_directories(.)

add_executable(task3
    company.cpp
    company.h
    doublyLink.h
    Employee.cpp
    Employee.h
    main.cpp)
