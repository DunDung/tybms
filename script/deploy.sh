REPOSITORY=/home/ubuntu/app
RESOURCES=/home/ubuntu/app/tybms/src/main/resources

echo "> 업로드 파일 임시 저장"

cp -r $RESOURCES/upload-files $REPOSITORY/

cd $REPOSITORY/tybms

echo "> Git Pull"

git pull

echo "> 업로드 파일 삭제 후 임시 저장한 폴더 복사"

rm -rf $RESOURCES/upload-files
cp -r $REPOSITORY/upload-files $RESOURCES/
rm -rf $REPOSITORY/upload-files

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