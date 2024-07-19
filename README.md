
1) Install Elasticsearch version 7.10 locally and start it up. (port : 9200)
2) Add the VM options
```
-javaagent:/{PROJECT_PATH}/lib/aspectjweaver-1.9.22.jar 
-javaagent:/{PROJECT_PATH}/lib/spring-instrument-6.1.10.jar.
```
3) Start the application.
4) Check the console for any error logs.
```
Caused by: org.hibernate.search.util.common.SearchException: HSEARCH000520: Hibernate Search encountered failures during bootstrap. Failures:

    Hibernate ORM mapping: 
        type 'com.example.demo.domain.Child': 
            path '.createdDate': 
                failures: 
                  - HSEARCH700079: Exception while retrieving property type model for 'createdDate' on 'com.example.demo.domain.Child'.
            path '.lastModifiedDate': 
                failures: 
                  - HSEARCH700079: Exception while retrieving property type model for 'lastModifiedDate' on 'com.example.demo.domain.Child'.
            path '.name': 
                failures: 
                  - HSEARCH700079: Exception while retrieving property type model for 'name' on 'com.example.demo.domain.Child'.
	at org.hibernate.search.engine.reporting.spi.RootFailureCollector.checkNoFailure(RootFailureCollector.java:67) ~[hibernate-search-engine-7.1.1.Final.jar:7.1.1.Final]
	at org.hibernate.search.engine.common.impl.SearchIntegrationBuilder.prepareBuild(SearchIntegrationBuilder.java:191) ~[hibernate-search-engine-7.1.1.Final.jar:7.1.1.Final]
	at org.hibernate.search.mapper.orm.bootstrap.impl.HibernateSearchPreIntegrationService$NotBooted.doBootFirstPhase(HibernateSearchPreIntegrationService.java:279) ~[hibernate-search-mapper-orm-7.1.1.Final.jar:7.1.1.Final]
	at org.hibernate.search.mapper.orm.bootstrap.impl.HibernateOrmIntegrationBooterImpl.bootNow(HibernateOrmIntegrationBooterImpl.java:179) ~[hibernate-search-mapper-orm-7.1.1.Final.jar:7.1.1.Final]
	at java.base/java.util.concurrent.CompletableFuture$UniApply.tryFire(CompletableFuture.java:646) ~[na:na]
	at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510) ~[na:na]
	at java.base/java.util.concurrent.CompletableFuture.complete(CompletableFuture.java:2179) ~[na:na]
	at org.hibernate.search.mapper.orm.bootstrap.impl.HibernateSearchSessionFactoryObserver.sessionFactoryCreated(HibernateSearchSessionFactoryObserver.java:41) ~[hibernate-search-mapper-orm-7.1.1.Final.jar:7.1.1.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.4.9.Final.jar:6.4.9.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:315) ~[hibernate-core-6.4.9.Final.jar:6.4.9.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:450) ~[hibernate-core-6.4.9.Final.jar:6.4.9.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1507) ~[hibernate-core-6.4.9.Final.jar:6.4.9.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.10.jar:6.1.10]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:390) ~[spring-orm-6.1.10.jar:6.1.10]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.10.jar:6.1.10]
	... 81 common frames omitted
	Suppressed: org.hibernate.search.util.common.SearchException: HSEARCH700079: Exception while retrieving property type model for 'createdDate' on 'com.example.demo.domain.Child'.
		at org.hibernate.search.mapper.pojo.model.hcann.spi.AbstractPojoHCAnnPropertyModel.handle(AbstractPojoHCAnnPropertyModel.java:94) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.processing.building.impl.PojoIndexingProcessorPropertyNodeBuilder.doBuild(PojoIndexingProcessorPropertyNodeBuilder.java:199) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.processing.building.impl.PojoIndexingProcessorPropertyNodeBuilder.build(PojoIndexingProcessorPropertyNodeBuilder.java:156) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.processing.building.impl.AbstractPojoIndexingProcessorTypeNodeBuilder.lambda$doBuild$0(AbstractPojoIndexingProcessorTypeNodeBuilder.java:127) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197) ~[na:na]
		at java.base/java.util.Iterator.forEachRemaining(Iterator.java:133) ~[na:na]
		at java.base/java.util.Spliterators$IteratorSpliterator.forEachRemaining(Spliterators.java:1939) ~[na:na]
		at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509) ~[na:na]
		at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) ~[na:na]
		at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151) ~[na:na]
		at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174) ~[na:na]
		at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) ~[na:na]
		at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596) ~[na:na]
		at org.hibernate.search.mapper.pojo.processing.building.impl.AbstractPojoIndexingProcessorTypeNodeBuilder.doBuild(AbstractPojoIndexingProcessorTypeNodeBuilder.java:130) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.processing.building.impl.AbstractPojoIndexingProcessorTypeNodeBuilder.build(AbstractPojoIndexingProcessorTypeNodeBuilder.java:97) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.mapping.impl.PojoIndexedTypeManager$Builder.preBuildIndexingProcessor(PojoIndexedTypeManager.java:186) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMapper.preBuildIndexingProcessorAndCollectDependencies(PojoMapper.java:390) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMapper.prepareBuild(PojoMapper.java:305) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.engine.common.impl.SearchIntegrationBuilder$MappingBuildingState.partiallyBuildAndAddTo(SearchIntegrationBuilder.java:287) ~[hibernate-search-engine-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.engine.common.impl.SearchIntegrationBuilder.prepareBuild(SearchIntegrationBuilder.java:188) ~[hibernate-search-engine-7.1.1.Final.jar:7.1.1.Final]
		... 94 common frames omitted
	Caused by: org.hibernate.AssertionFailure: Read method for enhanced field private java.time.LocalDateTime com.example.demo.domain.DomainBase.createdDate is unexpectedly missing.
		at org.hibernate.search.mapper.orm.model.impl.HibernateOrmBootstrapIntrospector.getBytecodeEnhancerReaderMethod(HibernateOrmBootstrapIntrospector.java:190)
		at org.hibernate.search.mapper.orm.model.impl.HibernateOrmBootstrapIntrospector.createValueReadHandle(HibernateOrmBootstrapIntrospector.java:126)
		at org.hibernate.search.mapper.orm.model.impl.HibernateOrmClassPropertyModel.createHandle(HibernateOrmClassPropertyModel.java:33)
		at org.hibernate.search.mapper.pojo.model.hcann.spi.AbstractPojoHCAnnPropertyModel.handle(AbstractPojoHCAnnPropertyModel.java:91)
		... 113 common frames omitted
	Caused by: java.lang.NoSuchMethodException: com.example.demo.domain.Child.$$_hibernate_read_createdDate()
		at java.base/java.lang.Class.getMethod(Class.java:2395)
		at org.hibernate.search.mapper.orm.model.impl.HibernateOrmBootstrapIntrospector.getBytecodeEnhancerReaderMethod(HibernateOrmBootstrapIntrospector.java:187)
		... 116 common frames omitted
	Suppressed: org.hibernate.search.util.common.SearchException: HSEARCH700079: Exception while retrieving property type model for 'lastModifiedDate' on 'com.example.demo.domain.Child'.
		at org.hibernate.search.mapper.pojo.model.hcann.spi.AbstractPojoHCAnnPropertyModel.handle(AbstractPojoHCAnnPropertyModel.java:94) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.processing.building.impl.PojoIndexingProcessorPropertyNodeBuilder.doBuild(PojoIndexingProcessorPropertyNodeBuilder.java:199) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.processing.building.impl.PojoIndexingProcessorPropertyNodeBuilder.build(PojoIndexingProcessorPropertyNodeBuilder.java:156) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.processing.building.impl.AbstractPojoIndexingProcessorTypeNodeBuilder.lambda$doBuild$0(AbstractPojoIndexingProcessorTypeNodeBuilder.java:127) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197) ~[na:na]
		at java.base/java.util.Iterator.forEachRemaining(Iterator.java:133) ~[na:na]
		at java.base/java.util.Spliterators$IteratorSpliterator.forEachRemaining(Spliterators.java:1939) ~[na:na]
		at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509) ~[na:na]
		at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) ~[na:na]
		at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151) ~[na:na]
		at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174) ~[na:na]
		at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) ~[na:na]
		at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596) ~[na:na]
		at org.hibernate.search.mapper.pojo.processing.building.impl.AbstractPojoIndexingProcessorTypeNodeBuilder.doBuild(AbstractPojoIndexingProcessorTypeNodeBuilder.java:130) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.processing.building.impl.AbstractPojoIndexingProcessorTypeNodeBuilder.build(AbstractPojoIndexingProcessorTypeNodeBuilder.java:97) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.mapping.impl.PojoIndexedTypeManager$Builder.preBuildIndexingProcessor(PojoIndexedTypeManager.java:186) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMapper.preBuildIndexingProcessorAndCollectDependencies(PojoMapper.java:390) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMapper.prepareBuild(PojoMapper.java:305) ~[hibernate-search-mapper-pojo-base-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.engine.common.impl.SearchIntegrationBuilder$MappingBuildingState.partiallyBuildAndAddTo(SearchIntegrationBuilder.java:287) ~[hibernate-search-engine-7.1.1.Final.jar:7.1.1.Final]
		at org.hibernate.search.engine.common.impl.SearchIntegrationBuilder.prepareBuild(SearchIntegrationBuilder.java:188) ~[hibernate-search-engine-7.1.1.Final.jar:7.1.1.Final]
		... 94 common frames omitted
```
