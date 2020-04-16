import org.mybatis.spring.annotation.MapperScan;

@Slf4j
@Configuration
@PropertySource("classpath:/application.yml")
@MapperScan(basePackages = "kr.co.openeg.mapper")
public class DatabaseConfiguration {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}

	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		log.info("datasource : {}", dataSource);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
//		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/board.xml"));
//		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/login.xml"));
//		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/member.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
