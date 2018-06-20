cmake_minimum_required(VERSION 3.4.1)

file(GLOB my_source
                     src/main/cpp/*.cpp
                     src/main/cpp/bzip2/*.c)
include_directories(src/main/cpp/bzip/)
add_library(native-lib
                      SHARED
                      ${my_source}  )

#add_subdirectory(src/main/cpp/bzip2)

find_library(log-lib log )

target_link_libraries(native-lib
                       ${log-lib}
                      )