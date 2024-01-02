import {BasicColumn, FormSchema} from '/@/components/Table';
import {rules} from '/@/utils/helper/validator';
//列表数据
export const columns: BasicColumn[] = [
    {
        title: '创建日期',
        align: "center",
        sorter: true,
        dataIndex: 'createTime'
    },
    {
        title: '更新人',
        align: "center",
        dataIndex: 'updateBy'
    },
    {
        title: '更新日期',
        align: "center",
        sorter: true,
        dataIndex: 'updateTime'
    },
    {
        title: '请求端口',
        align: "center",
        sorter: true,
        dataIndex: 'reqPort'
    },
    {
        title: '目标域名',
        align: "center",
        dataIndex: 'targetDomain'
    },
    {
        title: '状态',
        align: "center",
        sorter: true,
        dataIndex: 'status_dictText'
    },
    {
        title: '备注',
        align: "center",
        dataIndex: 'remark'
    },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
    {
        label: "请求端口",
        field: 'reqPort',
        component: 'Input',
        //colProps: {span: 6},
    },
    {
        label: "目标域名",
        field: 'targetDomain',
        component: 'Input',
        //colProps: {span: 6},
    },
    {
        label: "状态",
        field: 'status',
        component: 'JDictSelectTag',
        componentProps: {
            dictCode: "go_status"
        },
        //colProps: {span: 6},
    },
];
//表单数据
export const formSchema: FormSchema[] = [
    {
        label: '请求端口',
        field: 'reqPort',
        component: 'Input',
        dynamicRules: ({model, schema}) => {
            return [
                {required: true, message: '请输入请求端口!'},
                {...rules.duplicateCheckRule('go_router', 'req_port', model, schema)[0]},
            ];
        },
    },
    {
        label: '目标域名',
        field: 'targetDomain',
        component: 'Input',
        dynamicRules: ({model, schema}) => {
            return [
                {required: true, message: '请输入目标域名!'},
            ];
        },
    },
    {
        label: '状态',
        field: 'status',
        defaultValue: "1",
        component: 'JDictSelectTag',
        componentProps: {
            dictCode: "go_status"
        },
        dynamicRules: ({model, schema}) => {
            return [
                {required: true, message: '请输入状态!'},
            ];
        },
    },
    {
        label: '备注',
        field: 'remark',
        component: 'InputTextArea',
    },
    // TODO 主键隐藏字段，目前写死为ID
    {
        label: '',
        field: 'id',
        component: 'Input',
        show: false
    },
];


/**
 * 流程表单调用这个方法获取formSchema
 * @param param
 */
export function getBpmFormSchema(_formData): FormSchema[] {
    // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
    return formSchema;
}