package com.mx.kairos


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.codehaus.jackson.map.ObjectMapper
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import com.mx.kairos.controllers.ProductController
import spock.lang.Specification

@WebMvcTest(controllers = [ProductController])
class KairosApplicationTest extends Specification {

  @Autowired
  protected MockMvc mvc

  def "Should do a request"() {
    setup:
    ObjectMapper mapper = new ObjectMapper()
    when:
    def response = mvc
        .perform(MockMvcRequestBuilders.get("/products")

    ).andReturn().response
    then:
    response.status == MockHttpServletResponse.SC_OK
  }
}
