REPOSITORY=/home/ubuntu/app
ORIGIN_UPLOAD_FILE=/home/ubuntu/app/tybms/upload-files
TEMP_UPLOAD_FILE=/home/ubuntu/app/upload-files

echo "> 업로드 파일 임시 폴더로 이동"

mv $ORIGIN_UPLOAD_FILE $TEMP_UPLOAD_FILE

cd $REPOSITORY/tybms

echo "> Git Pull"

git pull

echo "> 업로드 파일 제자리로"

mv $TEMP_UPLOAD_FILE $ORIGIN_UPLOAD_FILE

echo "> Permission Denied 방지"

chmod +x gradlew

echo "> build 시작"

./gradlew build

echo "> Build 파일 복사"

cp ./build/libs/*.jar $REPOSITORY/

echo "> 현재 구동중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -f tybms)

echo "$CURRENT_PID"

if [ -z $CURRENT_PID ]; then
    echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
    echo "> 구동중인 애플리케이션 종료 kill -2 $CURRENT_PID"
    kill -9 $CURRENT_PID
    sleep 5
fi

echo "> 새 어플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

nohup java -jar -DSpring.profiles.active=prod $JAR_NAME 1> /dev/null 2>&1 &