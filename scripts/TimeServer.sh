#! /bin/bash
exec 3<> /dev/tcp/localhost/4415
cat <&3
exec 3<&-

