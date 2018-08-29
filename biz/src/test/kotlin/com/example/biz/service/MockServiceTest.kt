package com.example.biz.service

import com.example.base.config.BaseConfig
import com.example.biz.config.BizConfig
import com.example.biz.domain.Person
import com.example.biz.domain.TestPerson
import com.google.common.collect.Collections2
import com.google.common.collect.Ordering
import org.hamcrest.number.OrderingComparison
import org.joda.time.DateTime
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [BaseConfig::class, BizConfig::class])
@ActiveProfiles("dev")
class MockServiceTest {

    @Autowired
    private lateinit var mockService: MockService

    @Test
    fun testBean() {
        val person = mockService.mockPerson()
        println(person)
    }

    @Test
    fun testLocalDate() {
        var dayOfMonth = DateTime.now().dayOfMonth().dateTime.toLocalDate()
        val minusMonths = dayOfMonth.minusMonths(12)
        val list: MutableList<String> = arrayListOf()
        while (dayOfMonth != minusMonths) {
            list.add(dayOfMonth.toString("yyyy-MM"))
            dayOfMonth = dayOfMonth.minusMonths(1)
        }
        println(list)
    }

    @Test
    fun testSort() {


        val orders: MutableList<String> = arrayListOf("Jonathan", "Joseph", "Jotaro", "Josuke", "Jolyne")


        val list: MutableList<TestPerson> = arrayListOf()
        list.add(TestPerson("Joseph"))
        list.add(TestPerson("Jotaro"))
        list.add(TestPerson("Jolyne"))
        list.add(TestPerson("Josuke"))
        list.add(TestPerson("Jonathan"))

        val explicit = Ordering.explicit(orders)
        val c1: Comparator<TestPerson> = Comparator{o1, o2 ->
            if (orders.contains(o1.name) && orders.contains(o2.name)) {
                return@Comparator explicit.nullsFirst<String>().compare(o1.name, o2.name)
            }
            return@Comparator 1
        }
        Collections.sort(list, c1)
        println(list)
    }
}