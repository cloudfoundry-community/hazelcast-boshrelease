# BOSH Release for Hazelcast Data Grid

![sample1](http://docs.hazelcast.org/docs/3.6/manual/html-single/assets/img/logo.png)


This is an experimental Bosh release for Hazelcast Data Grid.

Hazelcast 3.6 brings the ability to plug discovery mechanism.

Features:
* integrates Hazelcast multi vm cluster in Bosh environment
* provides prepackaged Hazelcast Management Center (limited to 2 hosts max cluster without commercial license)
* leverages Hazelcast 3.6+ discovery mechanism, with consul connector
** just changing Bosh jobs/instances group size and the hazelcast clusters reconfigures itself with consul discovery 

Limitations:
* cloudfoundry broker not yet wired to Hazelcast broker
* expose in bosh manifest more Hazelcast cluster tuning options


use full links
* http://blog.hazelcast.com/cloud-foundry/
* https://github.com/hazelcast/hazelcast-cloudfoundry
* http://hazelcast.org/deployment-operations-guide/
* http://docs.hazelcast.org/docs/3.6/manual/html-single/index.html#system-properties
* https://github.com/bitsofinfo/hazelcast-consul-discovery-spi

inspiration
* https://github.com/cloudfoundry-community/memcache-release

reused bosh release:
* https://blog.starkandwayne.com/2016/01/06/a-generic-bosh-release-for-registering-service-brokers/
* https://github.com/Orange-OpenSource/java-openjdk-boshrelease
* https://github.com/cloudfoundry-community/consul-boshrelease
* https://github.com/cloudfoundry-community/route-registrar-boshrelease



## Usage

To use this bosh release, first upload it to your bosh:

```
bosh target BOSH_HOST
git clone https://github.com/cloudfoundry-community/hazelcast-boshrelease.git
cd hazelcast-boshrelease
bosh upload release releases/hazelcast-1.yml
```

For [bosh-lite](https://github.com/cloudfoundry/bosh-lite), you can quickly create a deployment manifest & deploy a cluster:

```
templates/make_manifest warden
bosh -n deploy
```

For AWS EC2, create a single VM:

```
templates/make_manifest aws-ec2
bosh -n deploy
```

### Override security groups

For AWS & Openstack, the default deployment assumes there is a `default` security group. If you wish to use a different security group(s) then you can pass in additional configuration when running `make_manifest` above.

Create a file `my-networking.yml`:

``` yaml
---
networks:
  - name: hazelcast1
    type: dynamic
    cloud_properties:
      security_groups:
        - hazelcast
```

Where `- hazelcast` means you wish to use an existing security group called `hazelcast`.

You now suffix this file path to the `make_manifest` command:

```
templates/make_manifest openstack-nova my-networking.yml
bosh -n deploy
```

### Development

As a developer of this release, create new releases and upload them:

```
bosh create release --force && bosh -n upload release
```

### Final releases

To share final releases:

```
bosh create release --final
```

By default the version number will be bumped to the next major number. You can specify alternate versions:


```
bosh create release --final --version 2.1
```

After the first release you need to contact [Dmitriy Kalinin](mailto://dkalinin@pivotal.io) to request your project is added to https://bosh.io/releases (as mentioned in README above).
