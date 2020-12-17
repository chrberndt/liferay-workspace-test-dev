/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sample.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.sample.model.Foo;
import com.liferay.sample.model.FooModel;
import com.liferay.sample.model.FooSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Foo service. Represents a row in the &quot;FOO_Foo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FooModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FooImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FooImpl
 * @generated
 */
@JSON(strict = true)
public class FooModelImpl extends BaseModelImpl<Foo> implements FooModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a foo model instance should use the <code>Foo</code> interface instead.
	 */
	public static final String TABLE_NAME = "FOO_Foo";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"fooId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"field1", Types.VARCHAR}, {"field2", Types.BOOLEAN},
		{"field3", Types.INTEGER}, {"field4", Types.TIMESTAMP},
		{"field5", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fooId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("field1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("field2", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("field3", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("field4", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("field5", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table FOO_Foo (uuid_ VARCHAR(75) null,fooId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,field1 VARCHAR(75) null,field2 BOOLEAN,field3 INTEGER,field4 DATE null,field5 VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table FOO_Foo";

	public static final String ORDER_BY_JPQL = " ORDER BY foo.field1 ASC";

	public static final String ORDER_BY_SQL = " ORDER BY FOO_Foo.field1 ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long FIELD2_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final long FIELD1_COLUMN_BITMASK = 16L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Foo toModel(FooSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Foo model = new FooImpl();

		model.setUuid(soapModel.getUuid());
		model.setFooId(soapModel.getFooId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setField1(soapModel.getField1());
		model.setField2(soapModel.isField2());
		model.setField3(soapModel.getField3());
		model.setField4(soapModel.getField4());
		model.setField5(soapModel.getField5());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Foo> toModels(FooSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Foo> models = new ArrayList<Foo>(soapModels.length);

		for (FooSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public FooModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fooId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFooId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fooId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Foo.class;
	}

	@Override
	public String getModelClassName() {
		return Foo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Foo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Foo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Foo, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Foo)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Foo, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Foo, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Foo)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Foo, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Foo, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Foo>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Foo.class.getClassLoader(), Foo.class, ModelWrapper.class);

		try {
			Constructor<Foo> constructor =
				(Constructor<Foo>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Foo, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Foo, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Foo, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Foo, Object>>();
		Map<String, BiConsumer<Foo, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Foo, ?>>();

		attributeGetterFunctions.put("uuid", Foo::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Foo, String>)Foo::setUuid);
		attributeGetterFunctions.put("fooId", Foo::getFooId);
		attributeSetterBiConsumers.put(
			"fooId", (BiConsumer<Foo, Long>)Foo::setFooId);
		attributeGetterFunctions.put("groupId", Foo::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Foo, Long>)Foo::setGroupId);
		attributeGetterFunctions.put("companyId", Foo::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Foo, Long>)Foo::setCompanyId);
		attributeGetterFunctions.put("userId", Foo::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Foo, Long>)Foo::setUserId);
		attributeGetterFunctions.put("userName", Foo::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Foo, String>)Foo::setUserName);
		attributeGetterFunctions.put("createDate", Foo::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Foo, Date>)Foo::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Foo::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Foo, Date>)Foo::setModifiedDate);
		attributeGetterFunctions.put("field1", Foo::getField1);
		attributeSetterBiConsumers.put(
			"field1", (BiConsumer<Foo, String>)Foo::setField1);
		attributeGetterFunctions.put("field2", Foo::getField2);
		attributeSetterBiConsumers.put(
			"field2", (BiConsumer<Foo, Boolean>)Foo::setField2);
		attributeGetterFunctions.put("field3", Foo::getField3);
		attributeSetterBiConsumers.put(
			"field3", (BiConsumer<Foo, Integer>)Foo::setField3);
		attributeGetterFunctions.put("field4", Foo::getField4);
		attributeSetterBiConsumers.put(
			"field4", (BiConsumer<Foo, Date>)Foo::setField4);
		attributeGetterFunctions.put("field5", Foo::getField5);
		attributeSetterBiConsumers.put(
			"field5", (BiConsumer<Foo, String>)Foo::setField5);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getFooId() {
		return _fooId;
	}

	@Override
	public void setFooId(long fooId) {
		_fooId = fooId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getField1() {
		if (_field1 == null) {
			return "";
		}
		else {
			return _field1;
		}
	}

	@Override
	public void setField1(String field1) {
		_field1 = field1;
	}

	@JSON
	@Override
	public boolean getField2() {
		return _field2;
	}

	@JSON
	@Override
	public boolean isField2() {
		return _field2;
	}

	@Override
	public void setField2(boolean field2) {
		_columnBitmask |= FIELD2_COLUMN_BITMASK;

		if (!_setOriginalField2) {
			_setOriginalField2 = true;

			_originalField2 = _field2;
		}

		_field2 = field2;
	}

	public boolean getOriginalField2() {
		return _originalField2;
	}

	@JSON
	@Override
	public int getField3() {
		return _field3;
	}

	@Override
	public void setField3(int field3) {
		_field3 = field3;
	}

	@JSON
	@Override
	public Date getField4() {
		return _field4;
	}

	@Override
	public void setField4(Date field4) {
		_field4 = field4;
	}

	@JSON
	@Override
	public String getField5() {
		if (_field5 == null) {
			return "";
		}
		else {
			return _field5;
		}
	}

	@Override
	public void setField5(String field5) {
		_field5 = field5;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Foo.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Foo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Foo toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Foo> escapedModelProxyProviderFunction =
				EscapedModelProxyProviderFunctionHolder.
					_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FooImpl fooImpl = new FooImpl();

		fooImpl.setUuid(getUuid());
		fooImpl.setFooId(getFooId());
		fooImpl.setGroupId(getGroupId());
		fooImpl.setCompanyId(getCompanyId());
		fooImpl.setUserId(getUserId());
		fooImpl.setUserName(getUserName());
		fooImpl.setCreateDate(getCreateDate());
		fooImpl.setModifiedDate(getModifiedDate());
		fooImpl.setField1(getField1());
		fooImpl.setField2(isField2());
		fooImpl.setField3(getField3());
		fooImpl.setField4(getField4());
		fooImpl.setField5(getField5());

		fooImpl.resetOriginalValues();

		return fooImpl;
	}

	@Override
	public int compareTo(Foo foo) {
		int value = 0;

		value = getField1().compareTo(foo.getField1());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Foo)) {
			return false;
		}

		Foo foo = (Foo)object;

		long primaryKey = foo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		_originalUuid = _uuid;

		_originalGroupId = _groupId;

		_setOriginalGroupId = false;

		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_setModifiedDate = false;

		_originalField2 = _field2;

		_setOriginalField2 = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Foo> toCacheModel() {
		FooCacheModel fooCacheModel = new FooCacheModel();

		fooCacheModel.uuid = getUuid();

		String uuid = fooCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			fooCacheModel.uuid = null;
		}

		fooCacheModel.fooId = getFooId();

		fooCacheModel.groupId = getGroupId();

		fooCacheModel.companyId = getCompanyId();

		fooCacheModel.userId = getUserId();

		fooCacheModel.userName = getUserName();

		String userName = fooCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			fooCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			fooCacheModel.createDate = createDate.getTime();
		}
		else {
			fooCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			fooCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			fooCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		fooCacheModel.field1 = getField1();

		String field1 = fooCacheModel.field1;

		if ((field1 != null) && (field1.length() == 0)) {
			fooCacheModel.field1 = null;
		}

		fooCacheModel.field2 = isField2();

		fooCacheModel.field3 = getField3();

		Date field4 = getField4();

		if (field4 != null) {
			fooCacheModel.field4 = field4.getTime();
		}
		else {
			fooCacheModel.field4 = Long.MIN_VALUE;
		}

		fooCacheModel.field5 = getField5();

		String field5 = fooCacheModel.field5;

		if ((field5 != null) && (field5.length() == 0)) {
			fooCacheModel.field5 = null;
		}

		return fooCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Foo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Foo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Foo, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Foo)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Foo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Foo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Foo, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Foo)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Foo>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _fooId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _field1;
	private boolean _field2;
	private boolean _originalField2;
	private boolean _setOriginalField2;
	private int _field3;
	private Date _field4;
	private String _field5;
	private long _columnBitmask;
	private Foo _escapedModel;

}