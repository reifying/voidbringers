# voidbringers

Clojure HelloWorld on Java11 runtime of Google Cloud Functions based on Stuart Halloway's [clojure-from-java](https://github.com/stuarthalloway/clojure-from-java).

1. [Install gcloud](https://cloud.google.com/sdk/docs/install)

2. Deploy

```
cd <project root>
gcloud functions deploy voidbringers --entry-point functions.HelloWorld --runtime java11 --trigger-http
```

3. Open ``httpsTrigger`` URL as listed in the gcloud output
