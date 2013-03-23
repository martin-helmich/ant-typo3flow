Ant tasks for TYPO3 Flow
========================

Author
------

Martin Helmich  
<typo3@martin-helmich.de>

Synopsis
--------

This package introduces several [Apache Ant](http://ant.apache.org/) tasks for administrating [TYPO3 Flow](http://flow.typo3.org) instances.

Installation
------------

### Compilation

Compile using ant:

    > ant

This will place the ant-typo3flow.jar in the `build/jar` directory.

### Usage

Include the following taskdef into your buildfile:

```xml
<taskdef resource="de/mittwald/ant/flow/tasks.properties">
    <classpath>
        <pathelement location="ant-typo3flow.jar"/>
    </classpath>
</taskdef>
```
