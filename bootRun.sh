#clean current process running on 9090
echo "killing current process running on 9090..."
fuser -n tcp -k 9090
#test comment to test the auto builds
#sleep for 10 seconds to kill the process
sleep 10
#clean temporary gradle directory
echo "Removing temporary gradle directory..."
rm -rf .gradle
#run spring boot in background
echo "Running gradle script to build the project..."
cd C:\Program Files (x86)\Jenkins\workspace\demo3
nohup gradle bootRun >> /tmp/bootRun.log 2>&1 &
