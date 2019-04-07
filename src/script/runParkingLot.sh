#!/bin/ksh
# shell Scripts for parking lot
# NOTE : Please change Java path and classpath before run below scripts
JAVA=/sbcimp/lib/jvm/jdk1.8.0_02//bin/java
CLASSPATH=/home/habibk/public/lib/parkinglot.jar:
if(( $#==0 ))
  then
    $JAVA -cp $CLASSPATH com.ParkingLot
else
    if(( $#==1 ]
    then
        $JAVA -cp $CLASSPATH com.ParkingLot $1
    else
        echo "more than 1 args passed"
    fi
fi