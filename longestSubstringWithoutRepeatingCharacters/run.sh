#!/bin/bash

arg=$1

case $arg in
    "java" )
        echo "compile java"
        javac lengthOfLongestSubstring.java
        java lengthOfLongestSubstring

    ;;
    "cpp" )
        make

    ;;
    
esac
