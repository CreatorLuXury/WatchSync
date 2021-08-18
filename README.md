# WatchSync
## Purpose 
File guarding and shareing files between servers.<br/>
Example:<br/>
You have 10 servers and you need to edit same configuration file on all servers.<br/>
With WatchSync all you need to do is edit config file are files will spread to defines locations.<br/>

## Options

 - supervised location
```
dir=/home/dev/
```

  - log location
```
log=./watchsync.log
```

 - server working port
```
port=2215
```

 - designate cluster hosts
```
hosts_propagation=192.168.0.2
```

- allow specific hosts to connect (CIDR is allowed)
```
hosts_allowed=192.168.0.1/24
```

 - customize ignore file
```
ingore_file=".watchsync"
```

 - synchronization time delay (minutes)
```
syncdelay=1
```

 - remove "guarded" files (dangerous)
```
allow_delete=0
```
